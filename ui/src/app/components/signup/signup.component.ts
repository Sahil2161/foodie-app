import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { User } from 'src/models/User.model';
import { UserService } from '../../services/user-service/user.service';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent {

  public securityQuestions: string[];

  myimg: any;

  gender: string[] = [
    "Female",
    "Male",
    "Other"
  ];

  user: User = new User;

  url = "https://www.trinidadrealtor.com/assets/front_end/images/avatar-person.svg";

  onFileSelected(fileInput: any) {
    if (fileInput.target.files && fileInput.target.files[0]) {

      let rdr = new FileReader();
      rdr.onload = (e: any) => {
        let img = new Image();
        img.src = e.target.result;
        img.onload = rs => {
          this.myimg = e.target.result;
        }
      };
      rdr.readAsDataURL(fileInput.target.files[0]);
    }
  }

  constructor(private userService: UserService) {
    this.securityQuestions = [
      "What is your graduation year?",
      "What is your first pet name?",
      "What is your birth month?",
      "What is your favourite food?",
      "What is your favourite place?"
    ]
  }

  saveUser(saveForm: NgForm) {
    
    this.user.pic = this.myimg;
    this.userService.saveUser(this.user).subscribe(
      data => {
        this.user = data;
        alert('Account created Sucessfully');
        console.log('data' + this.user);
      },
      httpErrorResponse => {
        if (!httpErrorResponse.ok) {
          alert(`User with email: ${this.user.emailId} alreay exists`);
        }
      }
    )
  }
}


// import { HttpClient } from '@angular/common/http';
// import { Injectable } from '@angular/core';
// import { Component, OnInit } from '@angular/core';
// import { Router } from '@angular/router';
// import { UserService } from 'src/app/services/user-service/user.service';
// import { User } from 'src/models/User.model';

// @Component({
//   selector: 'app-registration',
//   templateUrl: './signup.component.html',
//   styleUrls: ['./signup.component.css']
// })

// export class SignupComponent implements OnInit {

//   user: User = new User();
//   msg = '';
//   url = 'https://www.trinidadrealtor.com/assets/front_end/images/avatar-person.svg';

//   pic: any;

//   onselectFile(fileInput: any) {
//     if (fileInput.target.files && fileInput.target.files[0]) {

//       let rdr = new FileReader();
//       rdr.onload = (e: any) => {
//         let img = new Image();
//         img.src = e.target.result;
//         img.onload = rs => {
//           this.pic = e.target.result;
//         }
//       };
//       rdr.readAsDataURL(fileInput.target.files[0]);
//     }
//   }


//   constructor(private http: HttpClient, private router: Router, private _service: UserService) { }

//   ngOnInit(): void {
//   }
//   data!: {};

//   stu: User = new User();
//   students: Array<User> = [];


//   registerUser() {
//     this.user.pic = this.pic;
//     this._service.saveUser(this.user).subscribe(
//       data => {
//         console.log("response recieved");
//         alert("Register Successfully")

//         this.router.navigate(['/login'])

//       },
//       error => {
//         alert("Invalid Details")

//         console.log("exception occured");
//         this.msg = error.error;

//       }
//     )
//   } 
// }