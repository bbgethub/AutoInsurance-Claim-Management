import './App.css';
import Header from "./component/Header";
import Sidebar from './component/Sidebar';
import { BrowserRouter as Router,Routes,Route} from 'react-router-dom';
import Create from './pages/Create';
import Edit from './pages/Edit';
import View from './pages/View';


function App() {
  return (
    <Router>   
       <Header />
       <Sidebar />
       <Routes >
       <Route exact path="/create" element={<Create/>}/>
       <Route exact path="/" element={<Create/>}/>
       <Route path="/edit" element={<Edit/>}/>
       <Route path="/view" element={<View/>}/>
       </Routes >
    
    </Router>
  );
}

export default App;
