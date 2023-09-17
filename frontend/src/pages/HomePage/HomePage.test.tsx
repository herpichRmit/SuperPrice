import { describe, test, expect } from 'vitest'
import { render, screen } from '@testing-library/react'

import HomePage from "../../pages/HomePage/HomePage"

describe('Home page', () => {
  test('HomePage exists', () => {
    const homePage = render(<HomePage />)
    expect(homePage).toBeTruthy()
  });

  test('HomePage contains nav bar', () =>{
    const homePage = render(<HomePage />)
    const navBar = homePage.container.querySelector('.nav-bar');
    expect(navBar).toBeTruthy ();
  });

  test('Homepage contains search bar', () => {
    const homePage = render(<HomePage />)
    const searchBar = homePage.container.querySelector('.search-bar');
    expect(searchBar).toBeTruthy ();
  });

  test ('HomePage contains categories menu', () => {
    const homePage = render(<HomePage />)
    const categoriesMenu = homePage.container.querySelector('.categories-menu');
    expect(categoriesMenu).toBeTruthy ();
  });
});
