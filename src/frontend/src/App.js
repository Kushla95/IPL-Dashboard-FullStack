import "./App.css";
import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import { TeamPage } from "./pages/TeamPage";
import { MatchPage } from "./pages/MatchPage";

function App() {
  return (
    <div className="App">
      <Router>
        <Routes>
          <Route
            path="/teams/:teamName/matches/:year"
            element={<MatchPage />}
          />
          <Route path="/teams/:teamName" element={<TeamPage />} />
        </Routes>
      </Router>
    </div>
  );
}

export default App;
