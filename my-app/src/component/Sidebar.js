import React from 'react'
import "../sidebar.css";
import {Link} from "react-router-dom";
function Sidebar()
{
        return(<div className="sidebar">
        <Link to="/create"> Create </Link>
        <Link to="/edit"> Edit </Link>
        <Link to="/view"> View </Link>
      </div>);

}
export default Sidebar;