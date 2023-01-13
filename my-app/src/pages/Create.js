import React from "react";
import "../create.css";
function Create(){
    return(
        <div className="create">
             <div className="form-body">
              <div className="input-box">
                  <label className="form__label" for="firstName">First Name </label>
                  <input className="form__input" type="text" id="firstName" placeholder="First Name"/>
              </div>
              <div className="input-box">
                  <label className="form__label" for="lastName">Last Name </label>
                  <input  type="text" name="" id="lastName"  className="form__input"placeholder="LastName"/>
              </div>
              <div className="input-box">
                  <label className="form__label" for="email">Email </label>
                  <input  type="email" id="email" className="form__input" placeholder="Email"/>
              </div>
              <div className="input-box">
                  <label className="form__label" for="address">Address </label>
                  <input className="form__input" type="text"  id="address" placeholder="Address"/>
              </div>
              <div className="input-box">
                  <label className="form__label" for="phone">Phone </label>
                  <input className="form__input" type="text" id="phone" placeholder="Phone"/>
              </div>
              <div className="gender-details">
                  <label className="gender-title" for="gender">Gender </label>
                  <div className="category">
                  <input type="radio" value="Male" name="gender" /> Male
                  <input type="radio" value="Female" name="gender" /> Female
                  </div>
              </div>
              <div className="input-box">
              <label className="form__label" for="dob">Dob </label>
              <input className="form__input" type="text" id="dob" placeholder="dob"/>
              </div>
              <div className="input-box">
              <label className="form__label" for="policyno">Policy Number </label>
              <input className="form__input" type="text" id="policyno" placeholder="policy"/>
              </div>
              <div className="input-box">
              <label className="form__label" for="claim">Claim amount </label>
              <input className="form__input" type="text" id="claim" placeholder="claim amount"/>
              </div>
              <div className="input-box">
              <label className="form__label" for="supportdoc">Support Document </label>
              <input className="form__input" type="file" name="file" onChange="" />
              </div>

          </div>
          <div class="submit-button">
              <button class="btn">Submit</button>
          </div>
      </div>            
    );
}
export default Create;