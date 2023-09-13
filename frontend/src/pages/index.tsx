import Image from 'next/image'
import HomePage from './HomePage/HomePage';
import { useRouter } from 'next/router'
import Link from 'next/link'

import 'bootstrap/dist/css/bootstrap.min.css';

export default function Home() {
  return (
    <HomePage />
  );
};
