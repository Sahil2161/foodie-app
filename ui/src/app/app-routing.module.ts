import { NgModule } from '@angular/core';
import { Router, RouterModule, Routes } from '@angular/router';
import { ForgotpasswordComponent } from './components/forgotpassword/forgotpassword.component';
import { HomeComponent } from './components/home/home.component';
import { LoginComponent } from './components/login/login.component';
import { ResetpasswordComponent } from './components/resetpassword/resetpassword.component';
import { FavouriteComponent } from './components/favourite/favourite.component';
import { SignupComponent } from './components/signup/signup.component';

const routes: Routes = [
  {path: "", redirectTo: "/signup" , pathMatch: "full"},
  {path: "home", component: HomeComponent, children: [
    {path:"favourite",component:FavouriteComponent}
  ]},
  {path:"signup", component: SignupComponent},
  {path: "login", component: LoginComponent},
  {path: "forgot", component: ForgotpasswordComponent},
  {path:"reset",component:ResetpasswordComponent},
   //{path: "**", component: PageNotFoundComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { 
}

// TODO: add all components in an object