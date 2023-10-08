import Image from 'next/image'
import HomePage from '../pages/HomePage/HomePage';

import 'bootstrap/dist/css/bootstrap.min.css';

async function getCategory() {
  try {
    const res = await fetch(process.env.API_URL + '/api/catalog/category', { next: { revalidate: 0 } });

    if (!res.ok) {
      throw new Error('Failed to fetch data');
    }

    return await res.json();
  } catch (error) {
    // Handle the error here
    console.error('Error fetching data:', error);
    return null; // Return an appropriate value or handle the error as needed
  }
}

export default async function Home() {
  const arrCategory = await getCategory();

  if (arrCategory === null) {
    // Handle the error condition here
    return <div>Error: Failed to fetch data</div>;
  }

  return <HomePage inputCategories={arrCategory} />;
}
