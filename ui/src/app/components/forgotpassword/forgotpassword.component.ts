import { error } from '@angular/compiler/src/util';
import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Userfp } from 'src/models/Userfp.model';
import { UserService } from '../../services/user-service/user.service';

@Component({
  selector: 'app-forgotpassword',
  templateUrl: './forgotpassword.component.html',
  styleUrls: ['./forgotpassword.component.css']
})
export class ForgotpasswordComponent implements OnInit {
  email!: string;
  securityAnswer!: string;
  securityQuestion!: string;
  
  display: boolean = false;
  
  
  constructor(private userService: UserService) { }
  
  ngOnInit(): void {
    throw new Error('Method not implemented.');
  }

  onPress() {
    this.display = !this.display;
  }

  forgotPassword(saveForm: NgForm) {
    let user: Userfp = { "email": this.email, "securityQuestion": this.securityQuestion, "securityAnswer": this.securityAnswer }
    let userFound: Userfp;
    this.userService.forgotPassword(user).subscribe(
      data => {
        userFound = data;
      },
      error => {
        console.log(error);
      }
    )
  }
}
