import { Routes } from '@angular/router';
import { RpnComponent } from './components/rpn/rpn.component';

export const routes: Routes = [
    {path: 'rpn', component: RpnComponent},
    {path: '', redirectTo: 'rpn', pathMatch: 'full'},
];
