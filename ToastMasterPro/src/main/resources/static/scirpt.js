document.addEventListener("DOMContentLoaded", function () {
    const form = document.getElementById("roleForm");
    const roleNameInput = document.getElementById("roleName");
    const roleIdInput = document.getElementById("roleId");
    const submitBtn = document.getElementById("submitBtn");
    const rolesTableBody = document.querySelector("#rolesTable tbody");

    const apiBaseUrl = "/api/roles";

    // Load roles on page load
    fetchRoles();

    // Add or update role on form submission
    form.addEventListener("submit", function (event) {
        event.preventDefault();

        const roleName = roleNameInput.value.trim();
        const roleId = roleIdInput.value;

        if (roleName) {
            const roleData = {
                id: roleId ? parseInt(roleId) : undefined,
                roleName: roleName
            };

            const method = roleId ? "PUT" : "POST";
            const url = roleId ? `${apiBaseUrl}/${roleId}` : apiBaseUrl;

            fetch(url, {
                method: method,
                headers: {
                    "Content-Type": "application/json"
                },
                body: JSON.stringify(roleData)
            })
            .then(response => response.json())
            .then(() => {
                form.reset();
                fetchRoles();
            });
        }
    });

    // Fetch roles from API
    function fetchRoles() {
        fetch(apiBaseUrl)
            .then(response => response.json())
            .then(data => {
                rolesTableBody.innerHTML = "";
                data.forEach(role => {
                    const row = document.createElement("tr");

                    const idCell = document.createElement("td");
                    idCell.textContent = role.id;
                    row.appendChild(idCell);

                    const nameCell = document.createElement("td");
                    nameCell.textContent = role.roleName;
                    row.appendChild(nameCell);

                    const actionsCell = document.createElement("td");

                    const editBtn = document.createElement("button");
                    editBtn.textContent = "Edit";
                    editBtn.classList.add("action-btn", "edit-btn");
                    editBtn.addEventListener("click", function () {
                        roleIdInput.value = role.id;
                        roleNameInput.value = role.roleName;
                        submitBtn.textContent = "Update Role";
                    });
                    actionsCell.appendChild(editBtn);

                    const deleteBtn = document.createElement("button");
                    deleteBtn.textContent = "Delete";
                    deleteBtn.classList.add("action-btn", "delete-btn");
                    deleteBtn.addEventListener("click", function () {
                        deleteRole(role.id);
                    });
                    actionsCell.appendChild(deleteBtn);

                    row.appendChild(actionsCell);

                    rolesTableBody.appendChild(row);
                });
            });
    }

    // Delete role by ID
    function deleteRole(id) {
        fetch(`${apiBaseUrl}/${id}`, {
            method: "DELETE"
        })
        .then(() => fetchRoles());
    }
});
