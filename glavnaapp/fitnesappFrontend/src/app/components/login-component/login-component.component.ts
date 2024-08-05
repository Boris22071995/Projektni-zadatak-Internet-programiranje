import { Component, OnInit } from '@angular/core';
import { ImeServiceService } from 'src/app/services/imeService/ime-service.service';
import {FormBuilder, FormGroup, Validators} from '@angular/forms'
@Component({
  selector: 'app-login-component',
  templateUrl: './login-component.component.html',
  styleUrls: ['./login-component.component.css']
})
export class LoginComponentComponent implements OnInit {

  constructor(private categoryService: ImeServiceService,
              private formBuilder: FormBuilder    
    ) { }
public form: FormGroup = new FormGroup({});
  ngOnInit(): void {
    this.form = this.formBuilder.group({
      idCategory: [null],
      name: [null]
    });
  }
public add() {
console.log(this.form.value);
this.categoryService.addCategory(this.form.value).subscribe((res) => {
  console.log(res);
})
}
}
