import { useState } from 'react'
import { Card } from '/Users/marjr/OneDrive/Documentos/Trabalhos/Java/cardapio/Front/components/card/card';
import './App.css'
import { useFoodData } from '/Users/marjr/OneDrive/Documentos/Trabalhos//Java/cardapio/Front/hooks/useFoodData';
import { CreateModal } from '/Users/marjr/OneDrive/Documentos/Trabalhos/Java/cardapio/Front/components/create-modal/CreateModal';

function App() {

  const { data } = useFoodData();
  const [isModalOpen, setIsModalOpen] = useState(false);

  const handleOpenModal = () => {
    setIsModalOpen(prev => !prev)
  }

  return (
    <div className='container'>
      <h1>Cardapio</h1>
      <div className="card-grid">
      {data?.map(foodData => 
      <Card
        price={foodData.price}
        title={foodData.title}
        image={foodData.image}
        />
      )}
     </div>
     {isModalOpen && <CreateModal closeModal={handleOpenModal}/>}
     <button onClick={handleOpenModal}>novo</button>
    </div>
  )
}

export default App
