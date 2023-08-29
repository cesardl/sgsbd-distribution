import React from 'react';

const customers = [{
    "parcelId": 1,
    "description": "Proveedor 1",
    "status": "1"
},
    {
        "parcelId": 2,
        "description": "proveedor1",
        "status": "1"
    }];

const Customers = () => {
    return (
        <table>
            <thead>
            <th>ID</th>
            <th>Description</th>
            <th>State</th>
            </thead>
            <tbody>
            {customers.map(customer => {
                    const {parcelId, description, state} = customer;
                    return (
                        <tr key={parcelId}>
                            <td>{parcelId}</td>
                            <td>{description}</td>
                            <td>{state}</td>
                        </tr>
                    )
                }
            )}
            </tbody>
        </table>
    )
}

export default Customers;
