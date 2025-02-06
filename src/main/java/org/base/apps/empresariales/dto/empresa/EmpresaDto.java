package org.base.apps.empresariales.dto.empresa;

import java.util.List;

public class EmpresaDto {

    private List<EmpleadoDto> empleados;

    public List<EmpleadoDto> getEmpleados() {
        return empleados;
    }

    public void setEmpleados(List<EmpleadoDto> empleados) {
        this.empleados = empleados;
    }

    public Double salarioPromedioEmpleados(){
        Double promedio = 0.0;
        for(EmpleadoDto empleadoDto : empleados){
            promedio+=empleadoDto.getSalario();
        }
        return  promedio / empleados.size();
    }
}
