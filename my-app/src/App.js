import './App.css';
import Header from "./component/Header";
import Sidebar from './component/Sidebar';
import { BrowserRouter as Router,Routes,Route} from 'react-router-dom';
import Create from './pages/Create';
import Edit from './pages/Edit';
import View from './pages/View';
import ClaimList from './component/ClaimList/ClaimList';
import CreateClaim from './component/CreateClaim/CreateClaim';



function App() {
  return (
    <Router>   
       <Header />
       <Sidebar />
       <Routes >
       <Route exact path="/create" element={<Create/>}/>
       <Route exact path="/" element={<Create/>}/>
       <Route path="/edit" element={<Edit/>}/>
       <Route path="/view" element={<ClaimList/>}/>
       <Route path="/create2" element={<CreateClaim/>}/>
       </Routes >
    
    </Router>
  );
}

export default App;
