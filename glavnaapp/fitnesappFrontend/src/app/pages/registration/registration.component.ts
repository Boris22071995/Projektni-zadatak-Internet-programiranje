import { Component, OnInit,} from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { UserService } from 'src/app/services/UserService/user.service';
@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.css'],
})
export class RegistrationComponent implements OnInit {

  constructor(private userService: UserService,
              private formBuilder: FormBuilder) { }
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

  public add() {
    
    console.log(this.form.value);
    console.log(this.form2.value);
    // this.userService.addUser(this.form.value).subscribe((res) => {
    //   console.log(res);
    // })
  }


}
