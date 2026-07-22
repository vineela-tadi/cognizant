import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  isLoggedIn = true;   // false చేస్తే Home కి redirect అవుతుంది

}
