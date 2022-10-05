package com.example.appointmentmanagement.service.impl;

import com.example.appointmentmanagement.model.Appointment;
import com.example.appointmentmanagement.model.dto.AppointmentDTO;
import com.example.appointmentmanagement.repository.AppointmentRepository;
import com.example.appointmentmanagement.utility.AppointmentDtoToAppointment;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@Service
public class AppointmentServiceImpl {

    @Autowired
    private AppointmentRepository appointmentRepository;

    private static final Logger logger = Logger.getLogger("AppointmentServiceImpl");


    public String saveAppointment(AppointmentDTO appointmentDTO) {
        try {
            Appointment appointment = AppointmentDtoToAppointment.fromDto(appointmentDTO);
            if (Float.valueOf(appointment.getDuration()) <= 0.0) {
                return "Duration can not be less then or equals to 0 ";
            }
            appointmentRepository.save(appointment);
            logger.info("successfully saved appointment "+appointment.toString());
        }catch (Exception e){
            e.printStackTrace();
            return e.toString();
        }
        return "Added Appointment..";
    }


    public List<Appointment> getAll() {
        logger.info("getting all appointment present in the database.");
        return appointmentRepository.findAll();
    }

    public String update(AppointmentDTO appointmentDTO, int appointmentId) {
        String result = "";
        try {
            logger.info("updating appointment with id  = " + appointmentId);
            Optional<Appointment> DbAppointment = appointmentRepository.findById(appointmentId);
            if (!DbAppointment.isPresent()) {
                logger.info("no appointment present with id = " + appointmentId);
                return "No such Appoint is present...";
            }
            result = this.updateData(DbAppointment.get(), appointmentDTO);
        }catch (Exception e){
            e.printStackTrace();
            return e.toString();
        }
      return result;
    }

    private String updateData(Appointment oldAppointment, AppointmentDTO appointmentDTO) {
        if(appointmentDTO.getDuration()==null || appointmentDTO.getDuration().isEmpty() || Long.valueOf(appointmentDTO.getDuration())<=0){
            return "Duration can not be null, less then or equals to 0 ";
        }
        if(!appointmentDTO.getStartTime().isEmpty())  oldAppointment.setStartTime(appointmentDTO.getStartTime());
        if(!appointmentDTO.getDate().isEmpty()) oldAppointment.setDate(appointmentDTO.getDate());
        if(!appointmentDTO.getPurpose().isEmpty()) oldAppointment.setPurpose(appointmentDTO.getPurpose());
        appointmentRepository.save(oldAppointment);
        logger.info("updated the appointment {}"+oldAppointment);
        return "Appointment Updated..";
    }

    public String delete(int appointmentId) {
        Optional<Appointment> DbAppointment = appointmentRepository.findById(appointmentId);
        if(!DbAppointment.isPresent()){
            logger.info("no appointment present with id = "+appointmentId);
            return "No such Appoint is present...";
        }
        appointmentRepository.deleteById(appointmentId);
        return "Appointment Removed..";
    }

    public Appointment getById(int appointmentId) {
        Optional<Appointment> DbAppointment = appointmentRepository.findById(appointmentId);
        if(!DbAppointment.isPresent()){
            logger.info("no appointment present with id = "+appointmentId);
            return null;
        }
        return DbAppointment.get();
    }

    public List<Appointment> findAllBydate(String startDate, String endDate) {
        LocalDate sDate = LocalDate.parse(startDate);
        LocalDate eDate = LocalDate.parse(endDate);
        logger.info("start date = "+sDate.toString());
        logger.info("end date = "+eDate.toString());
        List<Appointment> result = new ArrayList<>();
        List<Appointment> allAppointments = appointmentRepository.findAll();
        for(Appointment appointment: allAppointments){
            if(LocalDate.parse(appointment.getDate()).isAfter(sDate) && LocalDate.parse(appointment.getDate()).isBefore(eDate)){
                result.add(appointment);
            }
        }
        logger.info("size of appointment by dates "+result.size());
        return result;
    }
}
