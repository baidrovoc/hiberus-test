import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Employee } from './employee';

@Injectable({
  providedIn: 'root'
})
export class EmployeeService {

  private urlBase = "http://localhost:8080/employee/"

  constructor(private clienteHttp: HttpClient) { }

  getEmployeeList(): Observable<Employee[]>{
    return this.clienteHttp.get<Employee[]>(this.urlBase+"All")
  }

  addEmployee(employee: Employee): Observable<Object>{
    return this.clienteHttp.post(this.urlBase+"create/"+Number(employee.departmentId), employee);
  }

  getEmployeeSalary(): Observable<Employee>{
    return this.clienteHttp.get<Employee>(this.urlBase+"highestSalary");
  }

  getAgeLow(): Observable<Employee>{
    return this.clienteHttp.get<Employee>(this.urlBase+"lowerAge");
  }

  getInputMonth(): Observable<number>{
    return this.clienteHttp.get<number>(this.urlBase+"countLastMonth");
  }
}
