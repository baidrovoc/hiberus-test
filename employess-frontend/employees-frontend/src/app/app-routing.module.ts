import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {EmployeesListComponent} from './employees-list/employees-list.component'
import { AddEmployeeComponent } from './add-employee/add-employee.component';
import { MetricsComponent } from './metrics/metrics.component';

const routes: Routes = [
  {path: 'empleados', component: EmployeesListComponent},
  {path:'', redirectTo: 'empleados', pathMatch:'full'},
  {path:'agregar-empleado', component: AddEmployeeComponent},
  {path:'metricas', component: MetricsComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
