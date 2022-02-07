import React from "react";
import {Link} from "react-router-dom";

const Menu = () => {
  return (
      <ul className="list-group">
        <li id="home" className="list-group-item active" aria-current="true">
          <Link to="/">Home</Link>
        </li>
        <li id="all" className="list-group-item">
          <Link to="all-employees">All employees</Link>
        </li>
        <li id="edit" className="list-group-item">Edit employee</li>
        <li id="create" className="list-group-item">Create employee</li>
        <li id="update" className="list-group-item">Update employee</li>
        <li id="delete" className="list-group-item">Delete employee</li>
      </ul>
  );
}

export default Menu;
