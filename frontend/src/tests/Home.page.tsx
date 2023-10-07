
import { describe, test, expect } from 'vitest'
import { render, screen } from '@testing-library/react'
import HomePage from '../pages/HomePage/HomePage';

describe('Home page', () => {
  test('Displays header', () => {
    const wrapper = render(<HomePage />)
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
