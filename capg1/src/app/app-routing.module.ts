import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { CapstoreHomeComponent } from './capstore-home/capstore-home.component';
import { ElectronicsComponent } from './electronics/electronics.component';
import { BooksComponent } from './books/books.component';
import { MobilesComponent } from './mobiles/mobiles.component';

const routes: Routes = [
  { path: 'home', component: CapstoreHomeComponent },
  { path: 'electronics', component: ElectronicsComponent },
  { path: 'mobiles', component: MobilesComponent },
  { path: 'books', component: BooksComponent },
  // { path: 'edit-user', component: EditUserComponent },
  // routerParams
  { path: '', component: CapstoreHomeComponent },
  // Or
  // {path:'',redirectTo:'/home',pathMatch:'full'},
  { path: '**', component: CapstoreHomeComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  
  exports: [RouterModule]
})
export class AppRoutingModule { }
