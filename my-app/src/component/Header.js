import React from 'react'
import "../header.css";
class Header extends React.Component
{
    render()
    {
        return(<div className="topnav">
        <a className="active" href="#home">Auto Claim Management</a>
        <div className="topnav-right">
          <button className="dropbtn">Admin</button>
          <div className="dropdown-content">
            <a href="#">Claims</a>
            <a href="#">Log out</a>
         </div>
        </div>
      </div>)

        
    }
}
export default Header;