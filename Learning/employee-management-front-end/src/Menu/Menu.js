import React from "react";
import {BiHomeAlt} from 'react-icons/bi'
import {BsPeople} from 'react-icons/bs'
import {NavLink} from "react-router-dom";

const Menu = () => {

  return (
      <ul className="list-group" style={{listStyle: "none"}}>
        <li>
          <NavLink className="list-group-item" activeClassName="active" to="/">
            <BiHomeAlt />
            <span className="p-4">Home</span>
          </NavLink>
        </li>
        <li>
          <NavLink className="list-group-item" activeClassName="active" to="all-employees">
            <BsPeople />
            <span className="p-4">All Employees</span>
          </NavLink>
        </li>
      </ul>
  );
}

export default Menu;
