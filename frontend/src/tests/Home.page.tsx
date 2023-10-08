
import { describe, test, expect } from 'vitest'
import { render, screen } from '@testing-library/react'
import HomePage from '../pages/HomePage/HomePage';

async function getCategory() {
  const res = await fetch(process.env.API_URL + '/api/catalog/category', { next: { revalidate: 0 } })

  if (!res.ok) {
    // This will activate the closest `error.js` Error Boundary
    throw new Error('Failed to fetch data')
  } else {
    return res.json()
  }
}

describe('Home page', () => {
  test('Displays header', async () => {
    const arrCategory = await getCategory()
    const wrapper = render(<HomePage inputCategories={arrCategory} />)
    expect(wrapper).toBeTruthy()

    // Should have nav bar
    const navBar = wrapper.container.querySelector('.nav-bar');
    expect(navBar).toBeTruthy ();

    // Should have search bar
    const searchBar = wrapper.container.querySelector('.search-bar');
    expect(searchBar).toBeTruthy ();

    // Should have categories
    const categoriesMenu = wrapper.container.querySelector('.categories-menu');
    expect(searchBar).toBeTruthy ();
  })
});
