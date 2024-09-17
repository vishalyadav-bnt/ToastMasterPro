package com.example.ToastMasterPro.Meeting.service.serviceimpl;

import java.time.LocalDate;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ToastMasterPro.Meeting.model.Meeting;
import com.example.ToastMasterPro.Meeting.model.MeetingAttendance;
import com.example.ToastMasterPro.Meeting.model.MeetingAttendanceDTO;
import com.example.ToastMasterPro.Meeting.model.MeetingRoleSetupDto;
import com.example.ToastMasterPro.Meeting.model.RoleSetup;
import com.example.ToastMasterPro.Meeting.repository.AttendanceRepository;
import com.example.ToastMasterPro.Meeting.repository.MeetingRepository;
import com.example.ToastMasterPro.Meeting.repository.RoleSetUpRepo;
import com.example.ToastMasterPro.Meeting.service.MeetingService;

@Service
public class MeetingServiceImpl implements MeetingService {
    @Autowired
    private MeetingRepository meetingRepository;

    @Autowired
    private RoleSetUpRepo roleSetUpRepo;

    @Autowired
    private AttendanceRepository attendanceRepository;

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    @Override
    public List<Meeting> getAllMeetings() {
        return meetingRepository.findAll();
    }

    @Override
    public Optional<Meeting> getMeetingById(Long meetingId) {
        return meetingRepository.findById(meetingId);
    }

    @Override
    public Meeting createMeeting(Meeting meeting) {
        return meetingRepository.save(meeting);
    }

    @Override
    public Meeting updateMeeting(Long id, Meeting meetingDetails) {
        Optional<Meeting> optionalMeeting = meetingRepository.findById(id);
        if (optionalMeeting.isPresent()) {
            Meeting meeting = optionalMeeting.get();
            meeting.setMeetingDate(meetingDetails.getMeetingDate());
            meeting.setStartTime(meetingDetails.getStartTime());
            meeting.setEndTime(meetingDetails.getEndTime());
            meeting.setLocation(meetingDetails.getLocation());
            meeting.setTheme(meetingDetails.getTheme());
            return meetingRepository.save(meeting);
        }
        return null; // Handle this case appropriately
    }

    @Override
    public void deleteMeeting(Long meetingId) {
        meetingRepository.deleteById(meetingId);
    }

    @Override
    public List<Meeting> gettAllMonthMeeting() {
        YearMonth currentMonth = YearMonth.now();
        LocalDate startOfMonth = currentMonth.atDay(1);
        LocalDate endOfMonth = currentMonth.atEndOfMonth();
     //   System.out.println("bhhjbjhbhjbjhbjbbjb jb kj" + currentMonth + "\t" + startOfMonth + "\t" + endOfMonth);
        String startDate = startOfMonth.format(FORMATTER);
        String endDate = endOfMonth.format(FORMATTER);

        return meetingRepository.findMeetingsInMonth(startDate, endDate);
    }

    @Override
    public void createRoleSetup(RoleSetup roleSetup) {
        roleSetUpRepo.save(roleSetup);
    }

    @Override
    public List<MeetingRoleSetupDto> fetchMeetingAndRoleSetupDetails() {
        return meetingRepository.fetchMeetingAndRoleSetupDetails();
    }

    @Override
    public void deleteRoleCount(Long id) {
        roleSetUpRepo.deleteById(id);
    }

    @Override
    public RoleSetup updateRoleCount(Long id, RoleSetup roleSetup) {
        Optional<RoleSetup> updateRole = roleSetUpRepo.findById(id);
        if (updateRole.isPresent()) {
            RoleSetup updateRoleCount = updateRole.get();
            updateRoleCount.setRoleCount(roleSetup.getRoleCount());
            updateRoleCount.setSpeakerCount(roleSetup.getSpeakerCount());
            updateRoleCount.setEvaluatorCount(roleSetup.getEvaluatorCount());
            return roleSetUpRepo.save(updateRoleCount);
        }
        return null;
    }

    @Override
    public MeetingAttendance storeAttendance(MeetingAttendance meetingAttendance) {
        return attendanceRepository.save(meetingAttendance);
      
    }

    @Override
    public List<MeetingAttendanceDTO> getMeetingDetails(Long meetingId) {
        return attendanceRepository.findMeetingAttendanceByMeetingId(meetingId);
    }

   public List<MeetingAttendanceDTO> getMeetingAttendanceByMonthAndYear(int month, int year) {
    LocalDate startDate = LocalDate.of(year, month, 1);
    LocalDate endDate = startDate.with(TemporalAdjusters.lastDayOfMonth());
    System.out.println(startDate);
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    // Convert LocalDate to String
    String startDateString = startDate.format(formatter);
    String endDateString = endDate.format(formatter);

    System.out.println("Start Date: " + startDateString);
    System.out.println("End Date: " + endDateString);

    return attendanceRepository.findMeetingAttendanceByDateRange(startDateString, endDateString);
}


   
}
