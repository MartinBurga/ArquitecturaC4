import { useState } from "react";
import axios from "axios";

function App() {
  // Inputs
  const [cedula, setCedula] = useState("");
  const [ruc, setRuc] = useState("");
  const [rucInfo, setRucInfo] = useState("");
  const [placa, setPlaca] = useState("");

  // Respuestas
  const [ant, setAnt] = useState(null);
  const [sri, setSri] = useState(null);
  const [sriInfo, setSriInfo] = useState(null);
  const [vehiculo, setVehiculo] = useState(null);

  // Control UI
  const [loading, setLoading] = useState(false);
  const [error, setError] = useState("");

  const API = "http://localhost:8080/api";

  // --- ANT ---
  const buscarANT = async () => {
    setLoading(true);
    setError("");
    setAnt(null);
    try {
      const res = await axios.get(`${API}/ant/${cedula}`);
      setAnt(res.data);
    } catch (e) {
      setError("Error consultando ANT");
    }
    setLoading(false);
  };

  // --- SRI: Es contribuyente ---
  const buscarSRI = async () => {
    setLoading(true);
    setError("");
    setSri(null);
    try {
      const res = await axios.get(`${API}/sri/${ruc}`);
      setSri(res.data); // {contribuyente: true/false}
    } catch (e) {
      setError("Error consultando SRI");
    }
    setLoading(false);
  };

  // --- SRI: Información detallada ---
  const buscarSRIInfo = async () => {
    setLoading(true);
    setError("");
    setSriInfo(null);
    try {
      const res = await axios.get(`${API}/sri/info/${rucInfo}`);
      setSriInfo(res.data);
    } catch (e) {
      setError("Error consultando información del contribuyente");
    }
    setLoading(false);
  };

  // --- Vehículo ---
  const buscarVehiculo = async () => {
    setLoading(true);
    setError("");
    setVehiculo(null);
    try {
      const res = await axios.get(`${API}/vehiculo/${placa}`);
      setVehiculo(res.data);
    } catch (e) {
      setError("Error consultando vehículo");
    }
    setLoading(false);
  };

  return (
    <div style={{ padding: "20px", fontFamily: "Arial" }}>
      <h1>ARQUITECTURA C4</h1>

      {loading && <p>Cargando...</p>}
      {error && <p style={{ color: "red" }}>{error}</p>}

      {/* -------------------- ANT -------------------- */}
      <div style={{ marginBottom: "20px", padding: "10px", border: "1px solid #ccc" }}>
        <h2>Consultar Puntos ANT</h2>
        <input
          value={cedula}
          onChange={(e) => setCedula(e.target.value)}
          placeholder="Cédula"
        />
        <button onClick={buscarANT}>Consultar</button>

        {ant && (
          <div style={{ marginTop: "10px" }}>
            <p><strong>Cédula:</strong> {ant.cedula}</p>
            <p><strong>Puntos:</strong> {ant.puntos}</p>
          </div>
        )}
      </div>

      {/* -------------------- SRI: Es contribuyente -------------------- */}
      <div style={{ marginBottom: "20px", padding: "10px", border: "1px solid #ccc" }}>
        <h2>Contribuyente SRI?</h2>
        <input
          value={ruc}
          onChange={(e) => setRuc(e.target.value)}
          placeholder="Ingresar RUC"
        />
        <button onClick={buscarSRI}>Consultar</button>

        {sri && (
          <div style={{ marginTop: "10px" }}>
            <p><strong>Es contribuyente:</strong> {sri.contribuyente ? "Sí" : "No"}</p>
          </div>
        )}
      </div>

      {/* -------------------- SRI: Información detallada -------------------- */}
      <div style={{ marginBottom: "20px", padding: "10px", border: "1px solid #ccc" }}>
        <h2>Información del Contribuyente SRI</h2>
        <input
          value={rucInfo}
          onChange={(e) => setRucInfo(e.target.value)}
          placeholder="RUC"
        />
        <button onClick={buscarSRIInfo}>Consultar</button>

        {sriInfo && (
          <div style={{ marginTop: "10px" }}>
            <p><strong>RUC:</strong> {sriInfo.numeroRuc}</p>
            <p><strong>Razon Social:</strong> {sriInfo.razonSocial}</p>
            <p><strong>Estado:</strong> {sriInfo.estadoContribuyenteRuc}</p>
            <p><strong>Actividad Principal:</strong> {sriInfo.actividadEconomicaPrincipal}</p>
            <p><strong>Tipo:</strong> {sriInfo.tipoContribuyente}</p>
            <p><strong>Fecha Inicio Actividades:</strong> {sriInfo.fechaInicioActividades}</p>
          </div>
        )}
      </div>

      {/* -------------------- VEHÍCULO -------------------- */}
      <div style={{ marginBottom: "20px", padding: "10px", border: "1px solid #ccc" }}>
        <h2>Consultar Vehículo</h2>
        <input
          value={placa}
          onChange={(e) => setPlaca(e.target.value.toUpperCase())}
          placeholder="Ingresar Placa"
        />
        <button onClick={buscarVehiculo}>Consultar</button>

        {vehiculo && (
          <div style={{ marginTop: "10px" }}>
            <p><strong>Placa:</strong> {vehiculo.placa}</p>
            <p><strong>Marca:</strong> {vehiculo.marca}</p>
            <p><strong>Modelo:</strong> {vehiculo.modelo}</p>
          </div>
        )}
      </div>
    </div>
  );
}

export default App;
