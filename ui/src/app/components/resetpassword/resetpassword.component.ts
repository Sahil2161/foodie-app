import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';

import { Userrp } from 'src/models/Userrp.model';
import { UserService } from '../../services/user-service/user.service';

@Component({
  selector: 'app-resetpassword',
  templateUrl: './resetpassword.component.html',
  styleUrls: ['./resetpassword.component.css']
})
export class ResetpasswordComponent implements OnInit {

  newPassword!: string;
  confirmPassword!: string;

  constructor(private userService: UserService) { }

  ngOnInit(): void {
  }

  resetPassword(saveForm: NgForm) {
    let user: Userrp = { "newPassword": this.newPassword, 
                          "confirmPassword": this.confirmPassword }
    
    let userFound: Userrp;
    
    this.userService.resetPassword(user).subscribe(
      data => {
        userFound: data;

        if (userFound.newPassword == user.newPassword && userFound.confirmPassword == user.confirmPassword) {
          alert("Password Changed👍");
        }
        else {
          alert("Check the Password☹️")
        }
      },
      error => {
        console.log(error);
      }
    )
  }
}
