import '../styles/PageTemplate.css';  

import React from 'react';
import { NavMenu } from './NavMenu';


export const PageTemplate = ({ children }) => 
  <div className="page">
    <div className="topbar">
      <div className="logo">
        <span>UrlRewrite Demo</span>
      </div>
      <NavMenu />
    </div>
    {children}
  </div>