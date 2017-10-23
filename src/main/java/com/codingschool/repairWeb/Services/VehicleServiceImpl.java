package com.codingschool.repairWeb.Services;

import com.codingschool.repairWeb.Domain.Vehicle;
import com.codingschool.repairWeb.Repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class VehicleServiceImpl implements VehicleService{

    @Autowired
    private VehicleRepository vehicleRepository;

    @Override
    public void save(Vehicle veh) {
        vehicleRepository.save(veh);
    }


    @Override
    public Vehicle findByPlate(String plate){

        Vehicle veh = vehicleRepository.findByPlate(plate);

        return veh;
    }

    @Override
    public List<Vehicle> find50VehiclesWithPlateAfter(String plate) {
        return vehicleRepository.findTop50ByPlateAfterOrderByPlate(plate);
    }
}
