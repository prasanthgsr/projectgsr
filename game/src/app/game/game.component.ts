import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { FormControl } from '../../../node_modules/@angular/forms';


@Component({
  selector: 'app-game',
  templateUrl: './game.component.html',
  styleUrls: ['./game.component.css']
})
export class GameComponent implements OnInit {
  gameForm: FormGroup;
  submitted: boolean = false;
  amt:any;
  constructor(private formBuilder: FormBuilder, private router: Router) { }

  ngOnInit() {
  //  this.gameForm=this.formBuilder.group()  
  this.gameForm=this.formBuilder.group({
    
    name:['',Validators.required,Validators.pattern("[a-zA-Z]{5,30}")],
    address:['',Validators.required]
    //amount:['',Validators.required]
  });
  }
  amount= new FormControl('');
  onSubmit(){
    this.submitted = true;
if(this.gameForm.invalid){
return;
    }
 localStorage.setItem("amt",this.amount.value);
 
 console.log(this.amt);

    this.router.navigate(['/play']);
  }
  getAmount(){
    localStorage.setItem("amt",this.amount.value);
    
  }
}
