import { Role } from './../models/role';
import { AuthenticationService } from './../services/authentication.service';
import { User } from './../models/user';
import { Address } from './../models/address';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.sass']
})
export class RegisterComponent implements OnInit {
  registerForm: FormGroup;

  constructor(private _formBuilder: FormBuilder, private _auth: AuthenticationService) { }

  ngOnInit(): void {
    this.registerForm = this._formBuilder.group({
      civilite: ['', [Validators.required]],
      prenom: ['', [Validators.required]],
      nom: ['', [Validators.required]],
      email: ['', [Validators.required, Validators.email]],
      password: ['', [Validators.required]],
      cpassword: ['', [Validators.required]],
      telephone: ['', [Validators.required]],
      street: ['', [Validators.required]],
      zipcode: ['', [Validators.required]],
      city: ['', [Validators.required]],
      country: ['', [Validators.required]]
    });
  }

  register() {
    console.log(this.registerForm);
    if (this.registerForm.invalid || (this.registerForm.value.password !== this.registerForm.value.cpassword)) {
      console.log('invalid form');
      return;
    }

    const role: Role = new Role();
    role.id = 3;
    role.nom = 'user';

    const adresse: Address = new Address();
    adresse.rue = this.registerForm.value.street;
    adresse.codePostal = this.registerForm.value.zipcode;
    adresse.ville = this.registerForm.value.city;
    adresse.pays = this.registerForm.value.country;

    const user: User = new User();
    user.civilite = this.registerForm.value.civilite;
    user.prenom = this.registerForm.value.prenom;
    user.nom = this.registerForm.value.nom;
    user.email = this.registerForm.value.email;
    user.password = this.registerForm.value.password;
    user.telephone = this.registerForm.value.telephone;
    user.adresse = adresse;
    user.role = role;


    this._auth.register(user).subscribe(data => {
      console.log(data);
    });


  }

}
