import React from 'react';
import { useAuth } from '../context/AuthContext';

const Dashboard = () => {
    const { user, logout } = useAuth();

    return (
        <div className="card" style={{ maxWidth: '600px' }}>
            <h1>Dashboard</h1>
            <div style={{ textAlign: 'left', marginBottom: '1.5rem' }}>
                <p><strong>Username:</strong> {user?.username}</p>
                <p><strong>Email:</strong> {user?.email}</p>
                <p><strong>Role:</strong> {user?.role}</p>
            </div>
            <button onClick={logout} style={{ background: 'linear-gradient(135deg, #f87171 0%, #ef4444 100%)' }}>
                Logout
            </button>
        </div>
    );
};

export default Dashboard;
