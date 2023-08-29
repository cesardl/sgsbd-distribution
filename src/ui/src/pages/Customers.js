import React, {useLayoutEffect, useState} from 'react';

const Customers = () => {
    const [customers, setCustomers] = useState([])

    useLayoutEffect(() => {
        const getCustomers = async () => {
            const res = await fetch('/api/parcels')
            const customers = await res.json();
            setCustomers(customers)
        }
        getCustomers().catch(e => {
            console.log('error fetching customer: ', e);
        })
    })

    return (
        <table>
            <thead>
            <tr>
                <th>ID</th>
                <th>Description</th>
                <th>State</th>
            </tr>
            </thead>
            <tbody>
            {customers.map(customer => {
                    const {parcelId, description, status} = customer;
                    return (
                        <tr key={parcelId}>
                            <td>{parcelId}</td>
                            <td>{description}</td>
                            <td>{status}</td>
                        </tr>
                    )
                }
            )}
            </tbody>
        </table>
    )
}

export default Customers;
