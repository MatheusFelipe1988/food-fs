import { useState } from 'react'
import { Card } from './components/card/card';
import './App.css'

function App() {

  const data = [];

  return (
    <div className='App'>
      <h1>Cardapio</h1>
      <div className="card-grid"></div>
      {data.map(foodData => <Card/>)}
      
    </div>
  )
}

export default App
