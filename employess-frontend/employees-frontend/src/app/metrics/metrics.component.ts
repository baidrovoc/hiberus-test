import { Component } from '@angular/core';
import { Employee } from '../employee';
import { EmployeeService } from '../employee.service';

@Component({
  selector: 'app-metrics',
  standalone: false,
  templateUrl: './metrics.component.html',
  styleUrl: './metrics.component.css'
})
export class MetricsComponent {

 employeesMaxSalary!: Employee;
 employeesAgeLow!: Employee;
 employeesInputMonth!: number;
 
   constructor(private employeeService: EmployeeService){}
 
   ngOnInit(){
     this.employeeService.getEmployeeSalary().subscribe
     (dato => {this.employeesMaxSalary=dato;});
    this.employeeService.getAgeLow().subscribe
     (dato1 => {this.employeesAgeLow=dato1;});
    this.employeeService.getInputMonth().subscribe
     ( {next: (total) => this.employeesInputMonth = total});

   }
 
 

}
