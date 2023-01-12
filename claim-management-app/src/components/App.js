import Layout from "./components/Layout";

import '../node_modules/bootstrap/dist/css/bootstrap.min.css';
import { BrowserRouter as Router, Route, Switch } from "react-router-dom";
import { NavigationBar } from './components/NavigationBar';
import { Home } from './Home';
import { About } from './About';
import { NoMatch } from './NoMatch';

function App() {
  return (
    <React.Fragment>
  <Router>
  <Switch>
  <Route exact path="/" component={Home} />
  <Route path="/about" component={About} />
  <Route component={NoMatch} />
</Switch>
    <NavigationBar />
  </Router>
</React.Fragment>
  );
}

export default App;