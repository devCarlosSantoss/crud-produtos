import { useState } from 'react';
import './App.css';
import Formulario from './components/Formulario';
import Tabela from './components/Tabela';

function App() {

  const [btnCadastrar, setbtnCadastrar] = useState(true)

  return (
    <div>
     <Formulario botao={btnCadastrar}/>
     <Tabela/>
    </div>
  );
}

export default App;
