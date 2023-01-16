import {React,useState} from "react";
import { useNavigate } from "react-router-dom";
import "../create.css";
import {createClaim} from "../ApiService/ClaimService.js"
import {createCustomer} from "../ApiService/CustomerService.js"
import {updatePolicy} from "../ApiService/PolicyService.js"
import {uploadDocument} from "../ApiService/DocumentService.js"



function Create(){
    const MAX_COUNT = 2;
    const navigate = useNavigate();
    const [firstName, setFirstName] = useState('fn');
    const [lastName, setLastName] = useState('ln');
    const [email, setEmail] = useState('v@yahoo.com');
    const [address,setAddress] = useState('123 ok streat');
    const [phone,setPhone] = useState('1234567899');
    const [gender,setGender] = useState('Male');
    const [dob,setDob] = useState('01/01/1900');
    const [policynum,setPolicynum] = useState('3');
    const [claimAmount,setclaimAmount] = useState('150');
	const [uploadedFiles, setUploadedFiles] = useState([])
    const [fileLimit, setFileLimit] = useState(false);
    const handleUploadFiles = files => {
        const uploaded = [...uploadedFiles];
        let limitExceeded = false;
        files.some((file) => {
            if (uploaded.findIndex((f) => f.name === file.name) === -1) {
                uploaded.push(file);
                if (uploaded.length === MAX_COUNT) setFileLimit(true);
                if (uploaded.length > MAX_COUNT) {
                    alert(`You can only add a maximum of ${MAX_COUNT} files`);
                    setFileLimit(false);
                    limitExceeded = true;
                    return true;
                }
            }
        })
        if (!limitExceeded) setUploadedFiles(uploaded)

    }

    const handleFileEvent =  (e) => {
        const chosenFiles = Array.prototype.slice.call(e.target.files)
        handleUploadFiles(chosenFiles);
    }

    const handleInputChange = (e) => {
        const {id , value} = e.target;
        if(id === "firstName"){
            setFirstName(value);
        }
        if(id === "lastName"){
            setLastName(value);
        }
        if(id === "email"){
            setEmail(value);
        }
        if(id === "address"){
            setAddress(value);
        }
        if(id === "phone"){
            setPhone(value);
        }
        if(id === "dob"){
            setDob(value);
        }
        if(id === "policynum"){
            setPolicynum(value);
        }
        if(id === "claimAmount"){
            setclaimAmount(value);
        }
    }
    const onOptionChange = e => {
        setGender(e.target.value);
      }
      
     const  handleSubmit  = async(e) => {
        e.preventDefault();

      
        // 👇 Uploading the files using the fetch API to the server


        console.log("submitbutton clicked");
        console.log(firstName,lastName,email,address,phone,dob,policynum,claimAmount,uploadedFiles);
        // create customer id
        var customer = {"firstname": firstName,
        "lastname": lastName,
        "phone": phone,
        "email": email,
        "gender": "Female",
        "address": address,
        "dob": dob
       };

 
      try{
      let custId= await createCustomer(customer);
      console.log("Create customer with id ",custId.id)
    
      const data = new FormData();
      data.append('customerId',custId.id)
      debugger
      uploadedFiles.forEach((file, i) => {
        data.append(`document`, file, file.name);
      });
      let docData = uploadDocument(data);
      debugger
      console.log("Create document for ",custId.id,docData)
      ;
      var policy = {
        number:policynum,
        customerid:custId.id,
        type:"AUTO"
      };
      let policyData = await updatePolicy(policy);
      debugger;
      console.log("Created/Updated customer "+ custId.id + " with policy "+policyData.number);

      var claim = {
        "amount":claimAmount,
        "policyNumber":policynum,
        "status":"",
        "Notes" :""
      };

      let claimId= await createClaim(claim);    
      console.log("Created Claim ", claimId) ; 
      debugger;
      }catch(e){
        return "Claim Cannot be created due to "+e;
      }
      debugger;
      navigate("/view");
    }
        
    return(
        <div className="create">
             <div className="form-body">
              <div className="input-box">
                  <label className="form__label" htmlFor="firstName">First Name </label>
                  <input className="form__input" type="text" value={firstName} onChange = {(e) => handleInputChange(e)} id="firstName" placeholder="First Name"/>
              </div>
              <div className="input-box">
                  <label className="form__label" htmlFor="lastName">Last Name </label>
                  <input  type="text" name="" id="lastName" value={lastName} onChange = {(e) => handleInputChange(e)} className="form__input"placeholder="LastName"/>
              </div>
              <div className="input-box">
                  <label className="form__label" htmlFor="email">Email </label>
                  <input  type="email" id="email" value={email} onChange = {(e) => handleInputChange(e)} className="form__input" placeholder="Email"/>
              </div>
              <div className="input-box">
                  <label className="form__label" htmlFor="address">Address </label>
                  <input className="form__input" type="text" value={address} onChange = {(e) => handleInputChange(e)} id="address" placeholder="Address"/>
              </div>
              <div className="input-box">
                  <label className="form__label" htmlFor="phone">Phone </label>
                  <input className="form__input" type="text" value={phone} onChange = {(e) => handleInputChange(e)} id="phone" placeholder="Phone"/>
              </div>
              <div className="gender-details">
                  <label className="gender-title" htmlFor="gender">Gender </label>
                  <div className="category">
                  <input type="radio" value="male" name="gender" checked={gender === "male"}
        onChange={onOptionChange}/> Male
                  <input type="radio" value="female" name="gender" checked={gender === "female"}
        onChange={onOptionChange} /> Female
                  </div>
              </div>
              <div className="input-box">
              <label className="form__label" htmlFor="dob">Dob </label>
              <input className="form__input" type="text" value={dob} onChange = {(e) => handleInputChange(e)} id="dob" placeholder="dob"/>
              </div>
              <div className="input-box">
              <label className="form__label" htmlFor="policyno">Policy Number </label>
              <input className="form__input" type="text" value={policynum} onChange = {(e) => handleInputChange(e)} id="policynum" placeholder="policy"/>
              </div>
              <div className="input-box">
              <label className="form__label" htmlFor="claim">Claim amount </label>
              <input className="form__input" type="text" value={claimAmount} onChange = {(e) => handleInputChange(e)} id="claimAmount" placeholder="claim amount"/>
              </div>
              <div className="input-box">
              <input id='fileUpload' type='file' multiple
					accept='application/pdf, image/png'
                    onChange={handleFileEvent}
                    disabled={fileLimit}
			/>

			<label htmlFor='fileUpload'>
				<a  className={`form__input ${!fileLimit ? '' : 'disabled' } `}>Upload Files</a>
			</label>

			<div className="uploaded-files-list">
				{uploadedFiles.map(file => (
                    <div >
                        {file.name}
                    </div>
                ))}
			</div>
              </div>

          </div>
        
          <div className="submit-button">
              <button onClick={(e)=>handleSubmit(e)} type="submit"  className="btn">Submit</button>
          </div>
      </div> 
                 
    );
}
export default Create;