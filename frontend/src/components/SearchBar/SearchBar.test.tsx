import { describe, test, expect } from 'vitest'
import { render, screen } from '@testing-library/react'

import SearchBar from "./SearchBar.tsx";

describe ("SearchBar",  () => {
    test ('Should contain form', () => {
        const searchBar = render (<SearchBar />);
        expect (searchBar.container.querySelector ('form')).toBeTruthy ();
    });

    test ('Should contain text field', () => {
        const searchBar = render (<SearchBar />);
        expect (searchBar.container.querySelector ('input[type=text]')).toBeTruthy ();
    });

   test ('Text field should be inside form', () => {
       const searchBar = render (<SearchBar />);
       expect (searchBar.container.querySelector ('form input[type=text]')).toBeTruthy ();
   });
});

