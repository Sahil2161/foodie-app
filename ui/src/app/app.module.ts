import { NgModule } from '@angular/core';
import { CommonModule} from '@angular/common';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { SignupComponent } from './components/signup/signup.component';
import { HomeComponent } from './components/home/home.component';
import { LoginComponent } from './components/login/login.component';
import { ForgotpasswordComponent } from './components/forgotpassword/forgotpassword.component';
import { ResetpasswordComponent } from './components/resetpassword/resetpassword.component';
import { RestaurantLoginComponent } from './components/restaurant-login/restaurant-login.component';
import { RestaurantsComponent } from './components/restaurants/restaurants.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { FavouriteComponent } from './components/favourite/favourite.component';
import { RecommendedComponent } from './recommended/recommended.component';

// material ui
// import { MatSliderModule } from '@angular/material/slider';

@NgModule({
  declarations: [
    AppComponent,
    SignupComponent,
    HomeComponent,
    LoginComponent,
    ForgotpasswordComponent,
    ResetpasswordComponent,
    RestaurantLoginComponent,
    RestaurantsComponent,
    FavouriteComponent,
    RecommendedComponent,
  ],
  imports: [
    BrowserModule,
    CommonModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    BrowserAnimationsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
