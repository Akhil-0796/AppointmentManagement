package com.example.appointmentmanagement.utility;

import com.example.appointmentmanagement.model.Appointment;
import com.example.appointmentmanagement.model.dto.AppointmentDTO;

public class AppointmentDtoToAppointment {

    public static Appointment fromDto(AppointmentDTO appointmentDTO){
        Appointment appointment = new Appointment();
        if(!appointmentDTO.getDuration().isEmpty()) appointment.setDuration(appointmentDTO.getDuration());
        if(!appointmentDTO.getPurpose().isEmpty()) appointment.setPurpose(appointmentDTO.getPurpose());
        if(!appointmentDTO.getDate().isEmpty()) appointment.setDate(appointmentDTO.getDate());
        if(!appointmentDTO.getStartTime().isEmpty()) appointment.setStartTime(appointmentDTO.getStartTime());
        return appointment;
    }
}
