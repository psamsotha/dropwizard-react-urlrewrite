import '../styles/ContactPage.css';

import React from 'react';
import { Route, NavLink, Switch } from 'react-router-dom';
import { PageTemplate } from './PageTemplate.js';


export const ContactNav = ({ match }) =>
  <div className="contact-links">
    <li><NavLink exact to="/contact" activeClassName="active">Email</NavLink></li>
    <li><NavLink to="/contact/phone" activeClassName="active" >Phone</NavLink></li>
    <li><NavLink to="/contact/twitter" activeClassName="active" >Twitter</NavLink></li>
  </div>

export const EmailPage = () =>
  <div className="email">
    <h3>Email</h3>
    <h4>demo@example.com</h4>
  </div>


export const PhonePage = () => 
  <div className="phone">
    <h3>Phone</h3>
    <h4>(415) 555 - 1234</h4>
  </div>


export const TwitterPage = () =>
  <div className="twitter">
    <h3>Twitter</h3>
    <h4>@exampleGods</h4>
  </div>


export const ContactPage = () =>
  <PageTemplate>
    <div className="contacts-page">
      <h1>Contact Page</h1>
      <section className="contact-info">
        <Route component={ContactNav} />
        <Route exact path="/contact" component={EmailPage} />
        <Route path="/contact/phone" component={PhonePage} />
        <Route path="/contact/twitter" component={TwitterPage} />
      </section>
    </div>
  </PageTemplate>
