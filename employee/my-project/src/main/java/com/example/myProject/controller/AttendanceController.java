package com.example.myProject.controller;

import com.example.myProject.common.vo.Result;
import com.example.myProject.entity.Attendance;
import com.example.myProject.service.AttendanceService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Field;
import java.util.List;

@Api(tags = "考勤")
@RestController
@RequestMapping("/attendance")
public class AttendanceController {

    @Autowired
    private AttendanceService attendanceService;

    @RequestMapping("/all")
    @ResponseBody
    public Result<List<Attendance>> attendanceList() {
        List<Attendance> list = attendanceService.selectList();
        return Result.success(list);
    }

    @RequestMapping("/selectById")
    @ResponseBody
    public Result<Attendance> selectById(Integer attendanceid) {
        Attendance attendance = attendanceService.selectById(attendanceid);
        return Result.success(attendance);
    }

    @RequestMapping("/selectByName")
    @ResponseBody
    public Result<List<Attendance>> selectByName(String name) {
        List<Attendance> attendances = attendanceService.selectByName(name);
        return Result.success(attendances);
    }

    @RequestMapping("/selectByDepartment")
    @ResponseBody
    public Result<List<Attendance>> selectByDepartment(String department) {
        List<Attendance> attendances = attendanceService.selectByDepartment(department);
        return Result.success(attendances);
    }

    @RequestMapping("/insertOne")
    @ResponseBody
    public void insertOne(Attendance attendance) {
        attendanceService.insertOne(attendance);
    }

    @RequestMapping("/updateOne")
    @ResponseBody
    public void updateOne(Attendance attendanceInput) {
        Attendance existingAttendance = attendanceService.getById(attendanceInput.getAttendanceid());

        updateFieldIfNotNull(existingAttendance, "cause", attendanceInput.getCause());
        updateFieldIfNotNull(existingAttendance, "name", attendanceInput.getName());
        updateFieldIfNotNull(existingAttendance, "department", attendanceInput.getDepartment());
        updateFieldIfNotNull(existingAttendance, "start", attendanceInput.getStart());
        updateFieldIfNotNull(existingAttendance, "end", attendanceInput.getEnd());

        attendanceService.updateOne(existingAttendance);
    }

    private void updateFieldIfNotNull(Attendance attendance, String fieldName, Object value) {
        if (value != null) {
            try {
                Field field = Attendance.class.getDeclaredField(fieldName);
                field.setAccessible(true);
                field.set(attendance, value);
            } catch (NoSuchFieldException | IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }

    @RequestMapping("/deleteOne")
    @ResponseBody
    public void deleteOne(Integer attendanceid) {
        attendanceService.deleteOne(attendanceid);
    }
}
