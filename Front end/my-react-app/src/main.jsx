import React from 'react';
import ReactDOM from 'react-dom';
import { BrowserRouter, Routes, Route } from 'react-router-dom';
import App from './App.jsx';
import './index.css';
import Login from './components/LoginForm.jsx';
import Register from './components/RegisterForm.jsx';
import ProductList from './components/ProductList.jsx';
import ProductView from './components/ProductView.jsx';

ReactDOM.createRoot(document.getElementById('root')).render(
  <BrowserRouter>
    <Routes>
      <Route path="/" element={<App />} />
      <Route path='/login' element={<Login/>} />
      <Route path='/products' element={<ProductList/>} />
      <Route path='/category/:id/products' element={<ProductList/>} />
      <Route path='/product/:id' element={<ProductView/>} />
      <Route path='/register' element={<Register/>} />
      
    </Routes>
  </BrowserRouter>
);
