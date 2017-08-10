import React from 'react';
import { NavLink } from 'react-router-dom';


export const NavMenu = ({ match }) =>
  <nav className="main-menu">
    <NavLink to="/" exact activeClassName="active">Home</NavLink>
    <NavLink to="/about" activeClassName="active">About</NavLink>
    <NavLink to="/contact" activeClassName="active">Contact</NavLink>
  </nav>
