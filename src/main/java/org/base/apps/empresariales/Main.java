package org.base.apps.empresariales;


import org.base.apps.empresariales.dto.banco.Pagable;
import org.base.apps.empresariales.dto.banco.TarjetaCredito;
import org.base.apps.empresariales.dto.banco.TransferenciaBancaria;
import org.base.apps.empresariales.dto.empresa.EmpleadoDto;
import org.base.apps.empresariales.dto.empresa.EmpresaDto;
import org.base.apps.empresariales.dto.vehiculos.CarroDto;
import org.base.apps.empresariales.dto.vehiculos.MotoDto;
import org.base.apps.empresariales.dto.vehiculos.VehiculoDto;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<EmpleadoDto> empleadoDtos = new ArrayList<>();
        empleadoDtos.add(new EmpleadoDto("Uno", 300.3, "desarrollador"));
        empleadoDtos.add(new EmpleadoDto("Dos", 150.3, "qa"));
        empleadoDtos.add(new EmpleadoDto("Tres", 450.3, "manager"));
        EmpresaDto empresaDto = new EmpresaDto();
        empresaDto.setEmpleados(empleadoDtos);
        System.out.println("El salario promedio de los empleados es: " + empresaDto.salarioPromedioEmpleados());
        VehiculoDto vehiculoDto = new CarroDto();
        System.out.println(vehiculoDto.acelerar());
        vehiculoDto = new MotoDto();
        System.out.println(vehiculoDto.acelerar());
        Pagable pagable = new TransferenciaBancaria();
        System.out.println(pagable.procesarPago());
        pagable = new TarjetaCredito();
        System.out.println(pagable.procesarPago());
    }


}