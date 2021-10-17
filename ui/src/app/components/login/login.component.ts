import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { UserAuth } from 'src/models/UserAuth.model';
import { UserService } from '../../services/user-service/user.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  emailId!: string;
  password!: string;

  constructor(private userService: UserService, private router: Router) { }

  ngOnInit(): void {
    throw new Error('Method not implemented.');
  }

  redirectToHome() {
    this.router.navigate(['home'])
  }

  login(saveForm: NgForm) {
    let user: UserAuth = { "emailId": this.emailId, "password": this.password };

    this.userService.login(user).subscribe(
      data => {
        if (data.emailId != null) {
          alert("Logged in👍");
          window.localStorage.setItem('emailId', data.emailId);
          this.userService.currentUser = data;
          localStorage.pic=data.pic;
          // redirect to home page
          this.redirectToHome();
        } 
      },
      error => {
        if(error.status == 404) {
          alert(`Invalid credentials`);
        }
      }
    )
  }
}
