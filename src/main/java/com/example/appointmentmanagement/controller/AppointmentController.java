package com.example.appointmentmanagement.controller;


import com.example.appointmentmanagement.model.Appointment;
import com.example.appointmentmanagement.model.dto.AppointmentDTO;
import com.example.appointmentmanagement.service.impl.AppointmentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AppointmentController {

    @Autowired
    private AppointmentServiceImpl appointmentService;

    /***
     * to add new appointment
     * @param appointment
     * @return message
     */
    @PostMapping("/save-appointment")
    public String addAppointment(@RequestBody AppointmentDTO appointment){
        return appointmentService.saveAppointment(appointment);
    }

    /***
     * to update the appointment
     * @param appointmentId
     * @param appointmentDTO
     * @return message
     */

    @PutMapping("/update-appointment/{appointmentId}")
    public String updateAppointment(@PathVariable(value = "appointmentId") int appointmentId,@RequestBody AppointmentDTO appointmentDTO){
        return appointmentService.update(appointmentDTO,appointmentId);
    }

    /***
     *  to get all appointment present in db
     * @return list of appointment objects
     */
    @GetMapping("/getAll")
    public List<Appointment> getAllAppointment(){
        return appointmentService.getAll();
    }

    /***
     *  to get appointment by id
     * @param appointmentId
     * @return appointment
     */
    @GetMapping("/get-by-id/{appointmentId}")
    public Appointment getAppointmentById(@PathVariable(value = "appointmentId") int appointmentId){
        return appointmentService.getById(appointmentId);
    }

    /***
     * to delete the appointment by id
     * @param appointmentId
     * @return message
     */
    @DeleteMapping("/delete-by-id/{appointmentId}")
    public String deleteAppointment(@PathVariable(value = "appointmentId") int appointmentId){
        return appointmentService.delete(appointmentId);
    }

    /***
     *  to get appointment between dates
     * @param startDate
     * @param endDate
     * @return list of appointments
     */

    @GetMapping("/get-by-date")
    public List<Appointment> getAllByDates(@RequestParam String startDate, @RequestParam String endDate){
        return appointmentService.findAllBydate(startDate, endDate);
    }
}
