import { Component, OnInit,} from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { Avatar } from 'src/app/interface/Avatar/Avatar';
import { User } from 'src/app/interface/User/User';
import { AvatarService } from 'src/app/services/avatarSerivce/avatar.service';
import { UserService } from 'src/app/services/UserService/user.service';
@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.css'],
})
export class RegistrationComponent implements OnInit {
 public user: User | null = null;
 public avatar: Avatar | null = null;
  constructor(private userService: UserService,
              private formBuilder: FormBuilder,
              private avatarService: AvatarService) {}
    public form: FormGroup = new FormGroup({});
    public form2: FormGroup = new FormGroup({});
  ngOnInit(): void {
    this.form = this.formBuilder.group({
      userName: [null],
      password: [null],
      firstName: [null],
      lastName: [null],
      email: [null],
      isActivated: false,
      programIdProgram: 1,
      city:[null]
    });
    this.form2 = this.formBuilder.group({
      content:[null],
      useridUser:[null]
    });
    
  }
  num: number = 0;
  public getUser() {
    this.userService.getUser().subscribe((res: User) => {this.user= {
      "idUser": res.idUser,
      "userName": res.userName,
      "password": res.password,
      "firstName": res.firstName,
      "lastName": res.lastName,
      "email": res.email,
      "city": res.city,
      "programIdProgram": 1,
      "isActivated": true 
    }

  });   
  }

  public addUserTmp() {
    this.userService.addUser(this.form.value).subscribe((res) => {
      this.user = res;
      console.log(res);
    });
  }

  public add() {
    this.userService.addUser(this.form.value).subscribe((res) => {
      this.user = res;
      console.log(res);
    });
    console.log(this.user);
    
  }


}
